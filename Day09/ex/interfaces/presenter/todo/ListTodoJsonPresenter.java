package ex.interfaces.presenter.todo;

import ex.interfaces.presenter.todo.model.ListTodoJsonOutput;
import ex.usecase.todo.dto.ListTodoOutput;

public interface ListTodoJsonPresenter {
    ListTodoJsonOutput Output(ListTodoOutput output);
    ListTodoJsonOutput Error(Exception e);
}
