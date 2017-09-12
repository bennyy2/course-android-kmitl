package kmitl.lab04.benjarat58070079.simplemydot.Model;


import java.util.ArrayList;
import java.util.List;

public class Dots {

    public interface OnDotsChangeListener{
        void onDotsChanged(Dots dots);
    }

    private OnDotsChangeListener listener;

    public void setListener(OnDotsChangeListener listener) {
        this.listener = listener;
    }

    private List<Dot> listDot = new ArrayList<>();

    public List<Dot> getListDot() {
        return listDot;
    }

    public void addDot(Dot dot){
        this.listDot.add(dot);
        this.listener.onDotsChanged(this);
    }


    public void removeBy(int position) {
        listDot.remove(position);
        this.listener.onDotsChanged(this);
    }

    public void clearAll() {
        listDot.clear();
        this.listener.onDotsChanged(this);
    }

    public int findDot(int x, int y) {
        for (int i = 0; i < listDot.size(); i++) {
            int centerX = listDot.get(i).getCenterX();
            int centerY = listDot.get(i).getCenterY();
            double distance = Math.sqrt(Math.pow(centerX - x, 2)) +
                    Math.sqrt(Math.pow(centerY - y, 2));
            if (distance <= 30) {
                return i;
            }
        }
        return -1;
    }


}
