package StudentServlst.Student;

import DAO.ExamDAO;
import Page.ChapterPage;
import Page.CoursePage;
import Page.ExamPage;
import Page.StudentPage;

import java.util.ArrayList;

/**
 * Created by 16689 on 2017/7/2.
 *
 * 有关于测试的相关类
 */
public class Question {
    private StudentPage studentPage;//学生
    private CoursePage coursePage;//课程
    private ChapterPage chapterPage;//章节

    private ArrayList<ExamPage> examPages;//章节的试题库
    private  ExamPage usingexampage;//正在使用的试题

    private  int count;//一套题目的题目数
    private  String [] answer;//正确的结果

    private  int grade; //测试结果 60 分为及格


    public Question(StudentPage studentPage, CoursePage coursePage, ChapterPage chapterPage) {
        this.studentPage = studentPage;
        this.coursePage = coursePage;
        this.chapterPage = chapterPage;
        setExamPages();//获得试题库，并设置随机题目
        setAnswer();//获得本试题的答案序列



    }

    public StudentPage getStudentPage() {
        return studentPage;
    }

    public void setStudentPage(StudentPage studentPage) {
        this.studentPage = studentPage;
    }

    public CoursePage getCoursePage() {
        return coursePage;
    }

    public void setCoursePage(CoursePage coursePage) {
        this.coursePage = coursePage;
    }

    public ChapterPage getChapterPage() {
        return chapterPage;
    }

    public void setChapterPage(ChapterPage chapterPage) {
        this.chapterPage = chapterPage;
    }

    public ArrayList<ExamPage> getExamPages() {
        return examPages;
    }

    public void setExamPages() {
        ExamDAO examDAO=new ExamDAO();
        examPages= (ArrayList<ExamPage>) examDAO.GetAllByColumn("chapterid",chapterPage.getId());
        int ran=getRandom(0,examPages.size()-1);
        setUsingexampage(examPages.get(ran));//获得随机的测试题
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ExamPage getUsingexampage() {
        return usingexampage;
    }

    public void setUsingexampage(ExamPage usingexampage) {
        this.usingexampage = usingexampage;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer() {
     String result=usingexampage.getAnswer();
     answer=result.split(",");
     count=answer.length;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public  int getRandom(int min,int Max)
    {
        int rand=min-1;
        if (Max>min)
        {
            while(!(rand>=min&&rand<=Max))
            {
                rand= (int) (Math.random()*10);
            }

        }
        else {
            rand=min;
        }
        return  rand;

    }
    public void evaluate(ArrayList<String> submit)
    {
        int right=0; //对的个数
        for (int i=0;i<answer.length;i++)
        {
            if(answer[i].equals(submit.get(i)))
            {
                right++;
            }
        }
        grade=(right/answer.length)*100;

    }


}
