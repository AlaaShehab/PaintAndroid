
public class MainFactory{
  
      public MouseDraw makeFactory(String btn){
          //TODO add path, and shapes
          if (btn.equals("Circle")){

              return new CircleFactory();

          } else if (btn.equals("Rec")){

              return new RectangleFactory();

          } else if (btn.equals("Sqr")){

              return new SquareFactory();

          } else return null;
      }
  }

