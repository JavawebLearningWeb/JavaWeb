package StudentServlst.Student;

import DAO.DataDAO;
import Page.ChapterPage;
import Page.DataPage;

import java.util.ArrayList;

/**
 * Created by 16689 on 2017/7/1.
 */
public class LearningData {
    private ChapterPage chapterPage;//课程属性
    private ArrayList<DataPage> learningall; //所有的资源列表
    private int count;//全部的资源总数
    private ArrayList<DataPage> learningppt;//ppt信息
    private int pptcount;
    private ArrayList<DataPage> learningmp4;//视频信息
    private int mp4count;


    public LearningData(ChapterPage chapterPage) {
        this.chapterPage = chapterPage;
        DataDAO dataDAO = new DataDAO();
        learningall = (ArrayList<DataPage>) dataDAO.GetAllByColumn("chapterid", chapterPage.getId());//获章节得全部资源列表
        setCount(learningall.size());
        learningclass();             //将学习资料进行分类 PPT，视频


    }

    public ArrayList<DataPage> getLearningppt() {
        return learningppt;
    }

    public void setLearningppt(ArrayList<DataPage> learningppt) {
        this.learningppt = learningppt;
    }


    public int getPptcount() {
        return pptcount;
    }

    public void setPptcount(int pptcount) {
        this.pptcount = pptcount;
    }

    public ArrayList<DataPage> getLearningmp4() {
        return learningmp4;
    }

    public void setLearningmp4(ArrayList<DataPage> learningmp4) {
        this.learningmp4 = learningmp4;
    }

    public int getMp4count() {
        return mp4count;
    }

    public void setMp4count(int mp4count) {
        this.mp4count = mp4count;
    }

    public ChapterPage getChapterPage() {
        return chapterPage;
    }

    public void setChapterPage(ChapterPage chapterPage) {
        this.chapterPage = chapterPage;
    }

    public ArrayList<DataPage> getLearningall() {
        return learningall;
    }

    public void setLearningall(ArrayList<DataPage> learningall) {
        this.learningall = learningall;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void learningclass()//将学习资料分类
    {
        learningppt = new ArrayList<>();
        learningmp4 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (learningall.get(i).getKind().equals("ppt")) {
                learningppt.add(learningall.get(i));
            }
            if (learningall.get(i).getKind().equals("视频")) {
                learningmp4.add(learningall.get(i));
            }
        }
        setPptcount(learningppt.size());
        setMp4count(learningmp4.size());

    }

}
