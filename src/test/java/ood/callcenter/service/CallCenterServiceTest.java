package ood.callcenter.service;

import ood.callcenter.domain.CallCenterTeam;
import ood.callcenter.domain.HistoryCalls;
import ood.callcenter.domain.IncomeCall;
import ood.callcenter.domain.PhoneCall;
import ood.callcenter.domain.employee.Fresher;
import ood.callcenter.domain.employee.ProjectManager;
import ood.callcenter.domain.employee.TeamLead;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;
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

        final int phoneCounts = 10;

        IntStream.range(0, phoneCounts).forEach(i ->
                        service.handleCall(new IncomeCall(i + 1000))
        );

        HistoryCalls historyCalls = service.getHistoryCalls();

        waitUntilAllPhoneCallsAreProcessed(historyCalls.phoneCalls(), phoneCounts);

        printHistoryCalls(historyCalls);

        assertThat(historyCalls.allEmployees())
                .extracting("supportLevel")
                .isSorted();
    }

    private void waitUntilAllPhoneCallsAreProcessed(List<PhoneCall> phoneCalls, int count) {
        while (phoneCalls.size() != count || phoneCalls.stream().anyMatch(p -> p.getDuration() == 0)) {
        }
    }

    private void printHistoryCalls(HistoryCalls historyCalls) {
        System.out.println("HISTORY CALLS");
        historyCalls.allEmployees().forEach(e -> {
            System.out.println(e + " -> ");
            historyCalls.getPhoneCallsBy(e).forEach(c -> System.out.println("   " + c));
        });
    }
}