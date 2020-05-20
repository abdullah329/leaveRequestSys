import {BalanceDeductionModel} from './BalanceDeductionModel';

export class LeaveAppListModel {
    sid: number;
    requestDate: String;
    leavingType: String;
    startdate: String;
    status: string;
    deductionlist: Array<BalanceDeductionModel>;
}