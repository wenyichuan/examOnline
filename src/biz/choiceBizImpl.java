package biz;

import bean.Choice;
import dao.choiceDao;
import dao.choiceDaoImpl;

import java.util.List;

public class choiceBizImpl implements choiceBiz {
    choiceDao choice =new choiceDaoImpl();

    @Override
    public List<Choice> getAll() {
        return choice.getAll();
    }

    @Override
    public int addChoice(Choice c) {
        return choice.addChoice(c);
    }
}
