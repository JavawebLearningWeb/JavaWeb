package StudentServlst.Student;

import DAO.ChapterDAO;
import DAO.ProgressDAO;
import Page.ChapterPage;
import Page.CoursePage;
import Page.ProgressPage;
import Page.StudentPage;

import java.util.ArrayList;

/**
 * Created by 16689 on 2017/6/29.
 */
public class Graph {
    private StudentPage studentPage;
    private CoursePage coursePage;
    private ArrayList<ChapterPage> chapterPageArrayList;
    private  int [] finishchapter;//完成章节信息表
    private  int chaptercount;
    int [][] grap;

    public Graph(StudentPage studentPage, CoursePage coursePage) {
        this.studentPage = studentPage;
        this.coursePage = coursePage;
        ChapterDAO chapterDAO=new ChapterDAO();
        chapterPageArrayList= (ArrayList<ChapterPage>) chapterDAO.GetAllByColumn("courseid",coursePage.getId());
        //获取全部的章节信息
        chaptercount=chapterPageArrayList.size();
        grap=new int[chaptercount][chaptercount];//创建二维矩阵
        finishchapter=new int[chaptercount];//完成章节的信息表
        createfinished();//将以及完成的章节进行记录

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

    public ArrayList<ChapterPage> getChapterPageArrayList() {
        return chapterPageArrayList;
    }

    public void setChapterPageArrayList(ArrayList<ChapterPage> chapterPageArrayList) {
        this.chapterPageArrayList = chapterPageArrayList;
    }

    public int getChaptercount() {
        return chaptercount;
    }

    public void setChaptercount(int chaptercount) {
        this.chaptercount = chaptercount;
    }

    public int[][] getGrap() {
        return grap;
    }

    public void setGrap(int[][] grap) {
        this.grap = grap;
    }

    public void createfinished(){
        for (int i=0;i<chaptercount;i++)
        {
            finishchapter[i]=0;
        }
        ProgressDAO progressDAO=new ProgressDAO();

        ArrayList<ProgressPage> progressPages= (ArrayList<ProgressPage>) progressDAO.GetAllByColumn("studentid",studentPage.getId(),"courseid",coursePage.getId());
        for (int i=0;i<chaptercount;i++)
        {
            for(int j=0;j<progressPages.size();j++)
            {
                if(chapterPageArrayList.get(i).getId().equals(progressPages.get(j).getChapterid()))
                {
                    finishchapter[i]=1;
                }
            }
        }
    }
}
