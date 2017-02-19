package ood.callcenter.service;

import ood.callcenter.domain.CallCenterTeam;
import ood.callcenter.domain.IncomeCall;
import ood.callcenter.domain.employee.Fresher;
import ood.callcenter.domain.employee.ProjectManager;
import ood.callcenter.domain.employee.TeamLead;
import org.junit.Test;

public class CallCenterServiceTest {

    @Test
    public void testHandleCall() throws Exception {
        CallCenterTeam team = new CallCenterTeam();
        team.addTeamMember(new TeamLead("team leader", 1));
        team.addTeamMember(new Fresher("fresher 2", 0));
        team.addTeamMember(new ProjectManager("project manager", 2));
        team.addTeamMember(new Fresher("fresher 1", 0));
//        team.addTeamMember(new Fresher("fresher 3", 0));

        CallCenterService service = new CallCenterService(team);
        service.handleCall(new IncomeCall(111));
        service.handleCall(new IncomeCall(222));
        service.handleCall(new IncomeCall(333));
        service.handleCall(new IncomeCall(444));
        service.handleCall(new IncomeCall(555));
        service.handleCall(new IncomeCall(666));
        service.handleCall(new IncomeCall(777));
        service.handleCall(new IncomeCall(888));
        service.handleCall(new IncomeCall(999));
        service.handleCall(new IncomeCall(1000));
        Thread.currentThread().sleep(5000);
    }
}