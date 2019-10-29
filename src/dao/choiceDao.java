package dao;

import bean.Choice;

import java.util.List;

public interface choiceDao {
    public List<Choice> getAll();
    public int addChoice(Choice choice);

}
