import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class ListTests {
  List<String> input1;
  @Before
  public void setUp(){
    input1 = new ArrayList<>();
    input1.add("abc");
    input1.add("def");
    input1.add("ghi");
  }
	@Test 
	public void testFilter() {
    input1.add("abcde");
    StringChecker abc = new StringChecker_abc();
    List<String> expected = new ArrayList<>();
    expected.add("abc");
    expected.add("abcde");
    List<String> actual = ListExamples.filter(input1, abc);
    assertEquals(expected.get(0), actual.get(0));
    assertEquals(expected.get(1), actual.get(1));
    assertEquals(expected.size(), actual.size());

	}
	@Test 
	public void testMerge() {
    List<String> input2 = new ArrayList<>();
    input2.add("abc");
    input2.add("fghij");
    List<String> actual = ListExamples.merge(input1, input2);
    List<String> expected = new ArrayList<>();
    expected.add("abc");
    expected.add("abc");
    expected.add("def");
    expected.add("fghij");
    expected.add("ghi");
    assertArrayEquals(expected.toArray(), actual.toArray());
	}

  @Test
	public void testMerge2() {
    List<String> input = new ArrayList<>();
    input.add("a");
    List<String> input2 = new ArrayList<>();
    input.add("b");
    List<String> actual = ListExamples.merge(input, input2);
    List<String> expected = new ArrayList<>();
    assertArrayEquals(expected.toArray(), actual.toArray());
}

@Test 
public void testMerge3() {
  List<String> input = new ArrayList<>();
  input.add("a");
  input.add("b");
  input.add("c");
  List<String> input2 = new ArrayList<>();
  input2.add("d");
  input2.add("e");
  input2.add("f");
  List<String> actual = ListExamples.merge(input, input2);
  List<String> expected = new ArrayList<String>();
  expected.add("a");
  expected.add("b");
  expected.add("c");
  expected.add("d");
  expected.add("e");
  expected.add("f");
  assertArrayEquals(expected.toArray(), actual.toArray());
}

}

class StringChecker_abc implements StringChecker{
  String checkString = "abc";
  public boolean checkString(String s){    return s.contains(checkString);   }
}
