package alpa.commands;

import alpa.utils.Storage;
import alpa.tasks.TaskList;
import alpa.ui.Ui;

public class ListCommand implements Command {
    
    @Override
    public void executeCommand(TaskList taskList, Ui ui, Storage storage) {
        ui.showTaskList(taskList.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

