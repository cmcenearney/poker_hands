package poker;

import org.junit.Test;
import poker.model.Card;
import poker.model.Hand;

public class ExpTest {

    public enum Types {
        ONE(Hand.class), TWO(Hand.class);
        Class classRef;
        Types(Class classRef){
            this.classRef = classRef;
        }
    }

//    @Test
//    public void testClassRefsInEnumCanInstantiate(){
//        Class oType = Types.ONE.classRef;
//        Object o = oType.getClassLoader().loadClass("Hand").newInstance();
//    }

}
