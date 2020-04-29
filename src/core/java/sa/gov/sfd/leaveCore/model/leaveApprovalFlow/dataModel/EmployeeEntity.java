/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

/**
 * @author abdullahalgarni on 16/04/2020 AD
 * @project leaveSystem
 **/
public class EmployeeEntity {

    private EmployeeNID employeeNID;
    private processFlowScenarioId approvalDeptGroupId;

    public EmployeeEntity(EmployeeNID employeeNID, processFlowScenarioId approvalDeptGroupId) {
        this.employeeNID = employeeNID;
        this.approvalDeptGroupId = approvalDeptGroupId;
    }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    public processFlowScenarioId getApprovalDeptGroupId() {
        return approvalDeptGroupId;
    }
}
