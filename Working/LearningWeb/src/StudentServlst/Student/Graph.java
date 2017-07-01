package StudentServlst.Student;

import DAO.AssociationDAO;
import DAO.ChapterDAO;
import DAO.ProgressDAO;
import Page.*;

import java.util.ArrayList;

/**
 * Created by 16689 on 2017/6/29.
 */
public class Graph {
    private StudentPage studentPage;//学生的信息
    private  ChapterPage learninngchapterPage;//正在学习的章节
    private CoursePage coursePage;
    private ArrayList<ChapterPage> chapterPageArrayList;//全部的章节信息
    private int[] finishchapter;//完成章节信息表
    private int chaptercount;//总的章节数
    private ArrayList<ChapterPage> finishedchapter;//已经完成的章节
    private int finishedcount;                    //已经完成的章节数
    private ArrayList<ChapterPage> learnchapter;//可以学习的章节
    private int learncount;                     //可以学习章节的个数
    int[][] graph;//图的数据结构结构


    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

    public Graph(StudentPage studentPage, CoursePage coursePage) {
        this.studentPage = studentPage;
        this.coursePage = coursePage;
        ChapterDAO chapterDAO = new ChapterDAO();
        chapterPageArrayList = (ArrayList<ChapterPage>) chapterDAO.GetAllByColumn("courseid", coursePage.getId());
        //获取全部的章节信息
        chaptercount = chapterPageArrayList.size();
        Pai();//按照要求排序,形成章节和序号之间的映射关系
        learnchapter=new ArrayList<>();
        finishedchapter = new ArrayList<>();
        finishchapter = new int[chaptercount];//完成章节的信息表
        createfinished();//将以及完成的章节进行记录

        setGraph();//将知识地图进行矩阵变化
        setLearnchapter();  //添加可以学习的课程


    }

    public int[][] getGraph() {
        return graph;
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


    public void setGraph() {
        graph = new int[chaptercount][chaptercount];//创建二维矩阵
        for (int i = 0; i < chaptercount; i++) {
            for (int j = 0; j < chaptercount; j++) {
                graph[i][j] = 0;
            }
        }
        AssociationDAO associationDAO = new AssociationDAO();
        ChapterDAO chapterDAO = new ChapterDAO();
        for (int i = 0; i < chaptercount; i++) {
            ChapterPage chapterPageA = chapterPageArrayList.get(i);
            ArrayList<AssociationPage> associationPages = (ArrayList<AssociationPage>) associationDAO.GetAllByColumn("prochapterid",
                    chapterPageArrayList.get(i).getId());
            for (int j = 0; j < associationPages.size(); j++) {
                ChapterPage chapterPageB = chapterDAO.GetById(associationPages.get(j).getChapterid());
                graph[Integer.valueOf(chapterPageA.getNumber()) - 1][Integer.valueOf(chapterPageB.getNumber()) - 1] = 1;
            }

        }

    }

    public void createfinished() {//记录以及完成的章节信息表
        for (int i = 0; i < chaptercount; i++) {
            finishchapter[i] = 0;//初始化
        }
        ProgressDAO progressDAO = new ProgressDAO();

        ArrayList<ProgressPage> progressPages = (ArrayList<ProgressPage>) progressDAO.GetAllByColumn("studentid", studentPage.getId(), "courseid", coursePage.getId());
        for (int i = 0; i < chaptercount; i++) {
            for (int j = 0; j < progressPages.size(); j++) {
                if (chapterPageArrayList.get(i).getId().equals(progressPages.get(j).getChapterid())) {
                    finishchapter[i] = 1;
                    finishedchapter.add(chapterPageArrayList.get(i));
                }
            }
        }
        finishedcount = finishedchapter.size();
    }

    public int[] getFinishchapter() {
        return finishchapter;
    }

    public void setFinishchapter(int[] finishchapter) {
        this.finishchapter = finishchapter;
    }

    public void Pai() {//对chapterlist进行排序
        int flag;
        ChapterPage chapterPage;
        int j = 0;
        int i = 0;
        for (i = 0; i < chaptercount; i++) {
            flag = i;
            for (j = i + 1; j < chaptercount; j++) {
                if (Integer.valueOf(chapterPageArrayList.get(j).getNumber()) < Integer.valueOf(chapterPageArrayList.get(flag).getNumber())) {
                    flag = j;
                }

            }
            chapterPage = chapterPageArrayList.get(i);
            chapterPageArrayList.set(i, chapterPageArrayList.get(flag));
            chapterPageArrayList.set(flag, chapterPage);

        }

    }

    public ArrayList<ChapterPage> getFinishedchapter() {
        return finishedchapter;
    }

    public void setFinishedchapter(ArrayList<ChapterPage> finishedchapter) {
        this.finishedchapter = finishedchapter;
    }

    public int getFinishedcount() {
        return finishedcount;
    }

    public void setFinishedcount(int finishedcount) {
        this.finishedcount = finishedcount;
    }

    public ArrayList<ChapterPage> getLearnchapter() {
        return learnchapter;
    }

    public void setLearnchapter() {


        for (int i=0;i<chaptercount;i++)
        {
            int sum=0;
            for (int j=0;j<chaptercount;j++)
            {
                sum+=graph[j][i];

            }
            if(sum==0)//零基础的节点                        1. 加入零基础的节点
            {
                learnchapter.add(chapterPageArrayList.get(i));
            }
        }

        for (int i=0;i<chaptercount;i++)
        {
            if(finishchapter[i]==1)
            {

               for (int j=0;j<learnchapter.size();j++)
               {
                   if(learnchapter.get(j).getId().equals(chapterPageArrayList.get(i).getId()))
                   {
                       learnchapter.remove(j);                 //2.剔除掉以及学习的课程,零基础还没有学习的课程
                   }
               }

            }
        }


        //                                                          3.添加已经学习课程的下一个节点
        for(int i=0;i<chaptercount;i++)
        {
            if(finishchapter[i]==1)
            {
                for (int j=0;j<chaptercount;j++)
                {
                    if(graph[i][j]==1)
                    {
                        learnchapter.add(chapterPageArrayList.get(j));
                    }
                }
            }
        }

        setLearncount(learnchapter.size());
    }


    public int getLearncount() {
        return learncount;
    }

    public void setLearncount(int learncount) {
        this.learncount = learncount;
    }

    public ChapterPage getLearninngchapterPage() {
        return learninngchapterPage;
    }

    public void setLearninngchapterPage(ChapterPage learninngchapterPage) {
        this.learninngchapterPage = learninngchapterPage;
    }

    public void setLearnchapter(ArrayList<ChapterPage> learnchapter) {
        this.learnchapter = learnchapter;
    }
}
