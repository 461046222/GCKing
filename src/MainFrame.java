import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by ZT on 2015/5/30.
 */
public class MainFrame {
public static void main(String[] args) {
    MyFrame mainFrame = new MyFrame();

    /*全屏代码*/
    //mainFrame.setUndecorated(true);
    //mainFrame.getGraphicsConfiguration().getDevice().setFullScreenWindow(mainFrame);

    mainFrame.setVisible(true);
}
}

class MyFrame extends JFrame{
    /** 定义变量 **/
    int chosenBtn=1;
    float UI_percentX=1f,UI_percentY=1f;                                                                                /**界面大小百分比*/

    ImageIcon BG=new ImageIcon(this.getClass().getResource("/BGPic.jpg"));                                              /**图片源*/
    ImageIcon IconExit=new ImageIcon(this.getClass().getResource("/Exit.jpg"));
    ImageIcon IconExitOnmove=new ImageIcon(this.getClass().getResource("/ExitOnmove.jpg"));
    ImageIcon IconExitOnclick=new ImageIcon(this.getClass().getResource("/ExitOnclick.jpg"));
    ImageIcon IconIntroduciton=new ImageIcon(this.getClass().getResource("/Introduction.jpg"));
    ImageIcon IconIntroducitonOnmove=new ImageIcon(this.getClass().getResource("/IntroductionOnmove.jpg"));
    ImageIcon IconIntroducitonOnclick=new ImageIcon(this.getClass().getResource("/IntroductionOnclick.jpg"));
    ImageIcon IconNVIDIA=new ImageIcon(this.getClass().getResource("/NVIDIA.jpg"));
    ImageIcon IconNVIDIAOnmove=new ImageIcon(this.getClass().getResource("/NVIDIAOnmove.jpg"));
    ImageIcon IconNVIDIAOnclick=new ImageIcon(this.getClass().getResource("/NVIDIAOnclick.jpg"));
    ImageIcon IconAMD=new ImageIcon(this.getClass().getResource("/AMD.jpg"));
    ImageIcon IconAMDOnmove=new ImageIcon(this.getClass().getResource("/AMDOnmove.jpg"));
    ImageIcon IconAMDOnclick=new ImageIcon(this.getClass().getResource("/AMDOnclick.jpg"));
    ImageIcon IconIntel=new ImageIcon(this.getClass().getResource("/Intel.jpg"));
    ImageIcon IconIntelOnmove=new ImageIcon(this.getClass().getResource("/IntelOnmove.jpg"));
    ImageIcon IconIntelOnclick=new ImageIcon(this.getClass().getResource("/IntelOnclick.jpg"));
    ImageIcon IconLadder=new ImageIcon(this.getClass().getResource("/Ladder.jpg"));
    ImageIcon IconLadderOnmove=new ImageIcon(this.getClass().getResource("/LadderOnmove.jpg"));
    ImageIcon IconLadderOnclick=new ImageIcon(this.getClass().getResource("/LadderOnclick.jpg"));

    JLabel BGLabel=new JLabel(BG){
        @Override                                                                                                       /**重写绘图方法*/
        public void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension size=this.getParent().getSize();
        g.drawImage(BG.getImage(),0,0,size.width,size.height,null);
    }
    };

    JPanel FunctionPanel=new JPanel(null);                                                                              /**功能Panel*/

    /**介绍组件*/
    JTextArea IntroductionText=new JTextArea("      显卡（Video card，Graphics card）全称显示接口卡，又称显示适配器，是计算机最基本配置、最重要的配件之一。显卡作为电脑主机里的一个重要组成部分，是电脑进行数模信号转换的设备，承担输出显示图形的任务。显卡接在电脑主板上，它将电脑的数字信号转换成模拟信号让显示器显示出来，同时显卡还是有图像处理能力，可协助CPU工作，提高整体的运行速度。对于从事专业图形设计的人来说显卡非常重要。 民用和军用显卡图形芯片供应商主要包括AMD(超微半导体)和Nvidia(英伟达)2家。");

    final MyButton ExitBtn=new MyButton(138,71,1301,890,IconExit,IconExitOnmove,IconExitOnclick,0);
    final MyButton IntroductionBtn=new MyButton(432,116,12,326,IconIntroduciton,IconIntroducitonOnmove,IconIntroducitonOnclick,1);
    final MyButton NvidiaBtn=new MyButton(432,116,11,453,IconNVIDIA,IconNVIDIAOnmove,IconNVIDIAOnclick,2);
    final MyButton AMDBtn=new MyButton(432,116,11,580,IconAMD,IconAMDOnmove,IconAMDOnclick,3);
    final MyButton IntelBtn=new MyButton(432,116,11,707,IconIntel,IconIntelOnmove,IconIntelOnclick,4);
    final MyButton LadderBtn=new MyButton(432,116,11,834,IconLadder,IconLadderOnmove,IconLadderOnclick,5);

    public MyFrame(){
        setLayout(null);                                                 /**设置Frame属性*/
        setSize(1440+15,960+40);                                        //15,40
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultLookAndFeelDecorated(true);
        setMinimumSize(new Dimension(720+15,480+40));

        BGLabel.setSize(1920,1080);                                      /**设置背景Label属性*/
        BGLabel.setLocation(0,0);

        IntroductionBtn.changeOnmoveIcon();

        FunctionPanel.setSize(850,500);                                  /**功能Panel初始化设置*/
        FunctionPanel.setLocation(540, 360);
        FunctionPanel.setOpaque(false);
        IntroductionText.setSize(850, 500);
        IntroductionText.setLineWrap(true);
        IntroductionText.setOpaque(false);
        IntroductionText.setFont(new Font("微软雅黑", Font.BOLD, 36));
        IntroductionText.setEditable(false);
        IntroductionText.setForeground(new Color(50,50,50));
        IntroductionText.setFocusable(false);
        FunctionPanel.add(IntroductionText);

        getLayeredPane().add(BGLabel,new Integer(0));                   /**添加容器至Frame*/
        getLayeredPane().add(ExitBtn, new Integer(1));
        getLayeredPane().add(IntroductionBtn, new Integer(1));
        getLayeredPane().add(NvidiaBtn, new Integer(1));
        getLayeredPane().add(AMDBtn, new Integer(1));
        getLayeredPane().add(IntelBtn, new Integer(1));
        getLayeredPane().add(LadderBtn, new Integer(1));
        getLayeredPane().add(FunctionPanel,new Integer(2));

        addComponentListener(new ComponentListener() {                                              /**监听窗口大小改变*/
            @Override
            public void componentResized(ComponentEvent e) {
                UI_percentX=(float)(getSize().width-15)/1440f;
                UI_percentY=(float)(getSize().height-40)/960f;
                LocationSet(UI_percentX,UI_percentY);
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    class MyButton extends JButton{                                     /**自定义按钮类*/
        boolean InBtn=false;
        int originLocX,originLocY,originSizeX,originSizeY;
        ImageIcon originimage=null,onmoveimage=null,onclickimage=null,chosenimage=null;
        public MyButton(int SizeX,int SizeY,int LocationX,int LocationY,final ImageIcon origin,final ImageIcon Onmove,final ImageIcon Onclick,final int Todo)      /**构造函数*/
        {
            originimage=origin;
            onmoveimage=Onmove;
            onclickimage=Onclick;
            originLocX=LocationX;
            originLocY=LocationY;
            originSizeX=SizeX;
            originSizeY=SizeY;
            chosenimage=originimage;
            setSize(SizeX,SizeY);
            setLocation(LocationX,LocationY);
            setIcon(origin);
            setBorder(null);

            addMouseListener(new MouseListener() {                                                      /**为按钮增加鼠标事件监听*/
                @Override
                public void mouseClicked(MouseEvent e) {
                    switch(Todo){
                        case 0:System.exit(0);break;
                        default:chosenBtn=Todo;checkBtn();break;
                    }

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    chosenimage=Onclick;
                    setIcon(Onclick);

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if(InBtn){
                        chosenimage=Onmove;
                        setIcon(Onmove);
                        mouseClicked(e);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    chosenimage=Onmove;
                    setIcon(Onmove);
                    InBtn=true;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    chosenimage=origin;
                    setIcon(origin);
                    checkBtn();
                    InBtn=false;
                }
            });
        }
        void checkBtn(){                                                                        /**检查设置正确的BUTTON图标*/
            dodefault();
            switch(chosenBtn){
                case 1:IntroductionBtn.changeOnmoveIcon();break;
                case 2:NvidiaBtn.changeOnmoveIcon();break;
                case 3:AMDBtn.changeOnmoveIcon();break;
                case 4:IntelBtn.changeOnmoveIcon();break;
                case 5:LadderBtn.changeOnmoveIcon();break;
            }
        }

        void dodefault(){                                                                       /**为每个BUTTON执行setDefault*/
            IntroductionBtn.setDefault();
            NvidiaBtn.setDefault();
            AMDBtn.setDefault();
            IntelBtn.setDefault();
            LadderBtn.setDefault();
        }

        public void setDefault(){                                                               /**设置BUTTON为默认图标*/
            setIcon(originimage);
            chosenimage=originimage;
        }

        public void changeOnmoveIcon(){                                                         /**设置BUTTON图标为移上时图标*/
            setIcon(onmoveimage);
            chosenimage=onmoveimage;
        }
        public void changeSizeandLocation(float i,float j){                                     /**按比例更改按钮大小和位置*/
            setLocation((int)((float)originLocX*i),(int)((float) originLocY*j));
            setSize((int) ((float) originSizeX * i), (int) ((float) originSizeY * j));
        }

        @Override
        public void paintComponent(Graphics g){                                                 /**重写绘制方法*/
            super.paintComponent(g);
            Dimension btnsize=getSize();
            g.drawImage(chosenimage.getImage(), 0, 0, btnsize.width, btnsize.height, null);
        }
    }

    private void LocationSet(float i,float j){                                                  /**设置各组件位置函数*/
        ExitBtn.changeSizeandLocation(i,j);
        IntroductionBtn.changeSizeandLocation(i,j);
        NvidiaBtn.changeSizeandLocation(i,j);
        AMDBtn.changeSizeandLocation(i,j);
        IntelBtn.changeSizeandLocation(i,j);
        LadderBtn.changeSizeandLocation(i, j);
        FunctionPanel.setLocation((int) (540f * i), (int) (360f * j));
        FunctionPanel.setSize((int) (850f * i), (int) (500f * j));
        IntroductionText.setSize((int)(850f*i),(int)(500f*j));
        IntroductionText.setFont(getFitFont(36, i, j));
    }

    private Font getFitFont(int oldfontsize,float i,float j){                                   /**字体区域完全填充字体大小计算,并返回字体**/
        Font newfont;
        int FontSize=oldfontsize;
        newfont=new Font("微软雅黑", Font.BOLD, (int)((float)FontSize*java.lang.StrictMath.sqrt(i*j)));
        return newfont;
    }
}

