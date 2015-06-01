import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ZT on 2015/5/30.
 */
public class MainFrame {
public static void main(String[] args) {
    MyFrame mainFrame = new MyFrame();
    mainFrame.setVisible(true);
}
}

class MyFrame extends JFrame{
    /** 定义变量 **/
    int chosenBtn=1;
    ImageIcon BG=new ImageIcon(this.getClass().getResource("/BGPic.jpg"));
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

    JLabel BGLabel=new JLabel(BG);

    JPanel FunctionPanel=new JPanel(null);

    JTextArea IntroductionText=new JTextArea("      显卡（Video card，Graphics card）全称显示接口卡，又称显示适配器，是计算机最基本配置、最重要的配件之一。显卡作为电脑主机里的一个重要组成部分，是电脑进行数模信号转换的设备，承担输出显示图形的任务。显卡接在电脑主板上，它将电脑的数字信号转换成模拟信号让显示器显示出来，同时显卡还是有图像处理能力，可协助CPU工作，提高整体的运行速度。对于从事专业图形设计的人来说显卡非常重要。 民用和军用显卡图形芯片供应商主要包括AMD(超微半导体)和Nvidia(英伟达)2家。");

    final MyButton ExitBtn=new MyButton(138,71,1302,889,IconExit,IconExitOnmove,IconExitOnclick,0);
    final MyButton IntroductionBtn=new MyButton(432,116,12,326,IconIntroduciton,IconIntroducitonOnmove,IconIntroducitonOnclick,1);
    final MyButton NvidiaBtn=new MyButton(432,116,11,453,IconNVIDIA,IconNVIDIAOnmove,IconNVIDIAOnclick,2);
    final MyButton AMDBtn=new MyButton(432,116,11,580,IconAMD,IconAMDOnmove,IconAMDOnclick,3);
    final MyButton IntelBtn=new MyButton(432,116,11,707,IconIntel,IconIntelOnmove,IconIntelOnclick,4);
    final MyButton LadderBtn=new MyButton(432,116,11,834,IconLadder,IconLadderOnmove,IconLadderOnclick,5);

    public MyFrame(){
        setLayout(null);                                                 /**设置Frame属性**/
        setSize(1440,960);
        setUndecorated(true);
        setLocationRelativeTo(null);

        BGLabel.setSize(1440,960);                                      /**设置背景Label属性**/
        BGLabel.setLocation(0,0);

        IntroductionBtn.setIcon(IntroductionBtn.onmoveimage);

        FunctionPanel.setSize(850,500);
        FunctionPanel.setLocation(540, 360);
        FunctionPanel.setOpaque(false);
        IntroductionText.setSize(850, 500);
        IntroductionText.setLineWrap(true);
        IntroductionText.setOpaque(false);
        IntroductionText.setFont(new Font("微软雅黑", Font.BOLD, 36));
        IntroductionText.setEditable(false);
        IntroductionText.setForeground(new Color(50,50,50));
        FunctionPanel.add(IntroductionText);

        getLayeredPane().add(BGLabel,new Integer(0));                   /**添加容器至Frame**/
        getLayeredPane().add(ExitBtn, new Integer(1));
        getLayeredPane().add(IntroductionBtn, new Integer(1));
        getLayeredPane().add(NvidiaBtn, new Integer(1));
        getLayeredPane().add(AMDBtn, new Integer(1));
        getLayeredPane().add(IntelBtn, new Integer(1));
        getLayeredPane().add(LadderBtn, new Integer(1));
        getLayeredPane().add(FunctionPanel,new Integer(2));
    }

    class MyButton extends JButton{                                     /**自定义按钮类**/
        boolean InBtn=false;
        ImageIcon originimage=null,onmoveimage=null,onclickimage=null;
        public MyButton(int SizeX,int SizeY,int LocationX,int LocationY,final ImageIcon origin,final ImageIcon Onmove,final ImageIcon Onclick,final int Todo)
        {
            originimage=origin;
            onmoveimage=Onmove;
            onclickimage=Onclick;
            setSize(SizeX,SizeY);
            setLocation(LocationX,LocationY);
            setIcon(origin);
            setBorder(null);

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    switch(Todo){
                        case 0:System.exit(0);break;
                        default:chosenBtn=Todo;checkBtn();break;
                    }

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    setIcon(Onclick);

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if(InBtn){
                        setIcon(Onmove);
                        mouseClicked(e);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    setIcon(Onmove);
                    InBtn=true;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setIcon(origin);
                    checkBtn();
                    InBtn=false;
                }
            });
        }
        void checkBtn(){
            dodefault();
            switch(chosenBtn){
                case 1:IntroductionBtn.setIcon(IntroductionBtn.onmoveimage);break;
                case 2:NvidiaBtn.setIcon(NvidiaBtn.onmoveimage);break;
                case 3:AMDBtn.setIcon(AMDBtn.onmoveimage);break;
                case 4:IntelBtn.setIcon(IntelBtn.onmoveimage);break;
                case 5:LadderBtn.setIcon(LadderBtn.onmoveimage);break;
            }
        }

        void dodefault(){
            IntroductionBtn.setIcon(IntroductionBtn.originimage);
            NvidiaBtn.setIcon(NvidiaBtn.originimage);
            AMDBtn.setIcon(AMDBtn.originimage);
            IntelBtn.setIcon(IntelBtn.originimage);
            LadderBtn.setIcon(LadderBtn.originimage);
        }
    }

}

