package oncall.controller;

import oncall.model.OncallBatch;
import oncall.model.OncallMonth;

public class OutputController extends BaseController {
    public void displayResult(OncallBatch oncallBatch, OncallMonth oncallMonth) {
        System.out.println();
        resultView.displayResult(oncallBatch, oncallMonth);
    }
}
