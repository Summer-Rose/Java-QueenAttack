import org.junit.*;
import java.util.Arrays;
import static org.junit.Assert.*;

public class UnitTest {

	@Test
	public void queenAttack_isFalseIftheCoordinatesAreNotHorizontalVeritcalOrDiagonalInLine_false() {
  	App yourApp = new App();
  	assertEquals(false, yourApp.queenAttack(11, 23));
	}

	@Test
	public void queenAttack_isTrueIftheCoordinatesAreHorizontalInLine_true() {
  	App yourApp = new App();
  	assertEquals(true, yourApp.queenAttack(11, 31));
	}

	@Test
	public void queenAttack_isTrueIfCoordinatesAreVertical_true() {
  	App yourApp = new App();
  	assertEquals(true, yourApp.queenAttack(11, 13));
	}

	@Test
	public void queenAttack_isTrueIfCoordinatesAreHorizontal_true() {
  	App yourApp = new App();
  	assertEquals(true, yourApp.queenAttack(42, 24));
  	}

  	@Test
	public void queenAttack_isTrueIfCoordinatesAreHorizontalType2_true() {
  	App yourApp = new App();
  	assertEquals(true, yourApp.queenAttack(11, 44));
	}
}
