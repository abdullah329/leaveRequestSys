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

package sa.gov.sfd.leaverequest.core.leaverequest;

import java.util.Objects;

/**
 * @author abdullahalgarni on 15/04/2020 AD
 * @project leaveSystem
 **/


public class LeaveRequestStatus {

    enum Status {
        WAITING("W"),
        DECLINED("D"),
        CONFIRMED("C");

        private String value;

        Status(String p) {
            value=p;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }


    private  Status requestStatus = null;

    public LeaveRequestStatus(String status) {

        switch (status) {
            case "W":
                requestStatus = Status.WAITING;
                break;

            case "D":
                requestStatus = Status.DECLINED;
                break;

            case "C":
                requestStatus = Status.CONFIRMED;
                break;

            default:
                requestStatus = Status.WAITING;
                break;
        }
    }

    public Status getRequestStatus() {
        return requestStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveRequestStatus that = (LeaveRequestStatus) o;
        return requestStatus.equals(that.requestStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestStatus);
    }

    @Override
    public String toString() {
        return "LeaveRequestStatus{" +
                "status='" + requestStatus + '\'' +
                '}';
    }
}


