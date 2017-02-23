package ood.callcenter.service;

import ood.callcenter.domain.CallCenterTeam;
import ood.callcenter.domain.HistoryCalls;
import ood.callcenter.domain.IncomeCall;
import ood.callcenter.domain.employee.Fresher;
import ood.callcenter.domain.employee.ProjectManager;
import ood.callcenter.domain.employee.TeamLead;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.Executors.newSingleThreadExecutor;
import static org.assertj.core.api.Assertions.assertThat;

public class CallCenterServiceTest {

    @Test
    public void testHandleCall() throws Exception {

        CallCenterTeam team = new CallCenterTeam();
        team.addTeamMember(new TeamLead("team leader", 1));
        team.addTeamMember(new Fresher("fresher 2", 0));
        team.addTeamMember(new ProjectManager("project manager", 2));
        team.addTeamMember(new Fresher("fresher 1", 0));
        team.addTeamMember(new Fresher("fresher 3", 0));


        CallCenterService service = new CallCenterService(team, newFixedThreadPool(8));

        List<IncomeCall> incomeCalls = generateIncomeCalls(10);

        incomeCalls.forEach(c -> service.handleCall(c));


        newSingleThreadExecutor().execute(() -> {
            while (incomeCalls.stream().anyMatch(c -> c.isInProgress())) {
                incomeCalls.stream()
                        .filter(call -> call.isInProgress())
                        .forEach(call -> {
                            sleep(500, 1000);
                            call.setInProgress(false);
                        });
            }
        });

        HistoryCalls historyCalls = service.getHistoryCalls();

        waitUntilAllPhoneCallsAreProcessed(incomeCalls, incomeCalls.size());

        printHistoryCalls(historyCalls);

        assertThat(historyCalls.allEmployees())
                .extracting("supportLevel")
                .isSorted();
    }

    private void waitUntilAllPhoneCallsAreProcessed(List<IncomeCall> phoneCalls, int count) {
        while (phoneCalls.size() != count || phoneCalls.stream().anyMatch(p -> p.isInProgress())) {
        }
    }

    private void printHistoryCalls(HistoryCalls historyCalls) {
        System.out.println("HISTORY CALLS");
        historyCalls.allEmployees().forEach(e -> {
            System.out.println(e + " -> ");
            historyCalls.getPhoneCallsBy(e).forEach(c -> System.out.println("   " + c));
        });
    }

    private List<IncomeCall> generateIncomeCalls(int phoneCounts) {
        List<IncomeCall> incomeCalls = new ArrayList<>();
        IntStream.range(0, phoneCounts).forEach(i -> {
            incomeCalls.add(new IncomeCall(i + 1000));
        });
        return incomeCalls;
    }

    private static long sleep(int max, int min) {
        long duration = min + (long) (Math.random() * ((max - min) + 1));
        try {
            Thread.currentThread().sleep(duration);
            return duration;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}