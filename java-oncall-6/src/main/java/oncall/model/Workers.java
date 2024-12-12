package oncall.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Workers {
    private Queue<String> workers;

    public Workers() {
    }

    public void saveWorkers(List<String> workerNameList) {
        this.workers = new LinkedList<>(workerNameList);
    }
}
