package biz;

import bean.Choice;

import java.util.List;

public interface choiceBiz {
    public List<Choice> getAll();
    public int addChoice(Choice choice);

}
