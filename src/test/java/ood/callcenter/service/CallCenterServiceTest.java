package ood.callcenter.service;

import ood.callcenter.domain.CallCenterTeam;
import ood.callcenter.domain.HistoryCalls;
import ood.callcenter.domain.IncomeCall;
import ood.callcenter.domain.employee.Fresher;
import ood.callcenter.domain.employee.ProjectManager;
import ood.callcenter.domain.employee.TeamLead;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.Executors.newSingleThreadExecutor;
import static org.assertj.core.api.Assertions.assertThat;

public class CallCenterServiceTest {

    @Test
    public void testHandleCall() throws Exception {

        CallCenterTeam team = new CallCenterTeam();
        team.addTeamMember(new ProjectManager().setName("project manager").setSupportLevel(2));
        team.addTeamMember(new TeamLead().setName("team leader").setSupportLevel(1));
//        team.addTeamMember(new Fresher().setName("fresher 3").setSupportLevel(0));
//        team.addTeamMember(new Fresher().setName("fresher 2").setSupportLevel(0));
        team.addTeamMember(new Fresher().setName("fresher 1").setSupportLevel(0));

        CallCenterService service = new CallCenterService(team, newFixedThreadPool(8));

        List<IncomeCall> incomeCalls = generateIncomeCallsWithCount(10);

        incomeCalls.forEach(c -> service.handleCall(c));

        terminateCallsAsync(incomeCalls);

        waitUntilAllCallsAreHandled(incomeCalls);

        HistoryCalls historyCalls = service.getHistoryCalls();

        printHistoryCalls(historyCalls);

        assertThat(historyCalls.allEmployees())
                .extracting("supportLevel")
                .isSorted()
                .startsWith(team.findAnyBy(Fresher.class).getSupportLevel())
                .endsWith(team.findAnyBy(ProjectManager.class).getSupportLevel());
    }

    private void terminateCallsAsync(List<IncomeCall> incomeCalls) {
        newSingleThreadExecutor().execute(() -> {
            while (incomeCalls.stream().anyMatch(c -> c.isInProgress() || c.getDuration() == 0)) {
                incomeCalls.stream()
                        .filter(call -> call.isInProgress() || call.getDuration() == 0)
                        .forEach(call -> {
                            sleepWithRange(500, 1000);
                            call.setInProgress(false);
//                            System.out.println("interrupted=" + call);
                        });
            }
            System.out.println("All calls interrupted");
        });
    }

    private void waitUntilAllCallsAreHandled(List<IncomeCall> phoneCalls) throws InterruptedException {
        while (phoneCalls.stream().anyMatch(p -> p.getDuration() == 0) ||
                phoneCalls.stream().anyMatch(p -> p.isInProgress())) {
            Thread.currentThread().sleep(100);
//            System.out.println("in progress now = " + phoneCalls.stream().filter(p -> p.getDuration() == 0).count());
        }
    }

    private void printHistoryCalls(HistoryCalls historyCalls) {
        System.out.println("HISTORY CALLS");
        historyCalls.allEmployees().forEach(e -> {
            System.out.println(e + " -> ");
            historyCalls.getPhoneCallsBy(e).forEach(c -> System.out.println("   " + c));
        });
    }

    private List<IncomeCall> generateIncomeCallsWithCount(int phoneCounts) {
        List<IncomeCall> incomeCalls = new CopyOnWriteArrayList<>();
        IntStream.range(0, phoneCounts).forEach(i ->
            incomeCalls.add(new IncomeCall(i + 1000))
        );
        return incomeCalls;
    }

    private static long sleepWithRange(int max, int min) {
        long duration = min + (long) (Math.random() * ((max - min) + 1));
        try {
            Thread.currentThread().sleep(duration);
            return duration;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}