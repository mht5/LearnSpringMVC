package chapter13.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import chapter02.action.PDFActionTest;

/**
 * ʹ�ò����׼�
 * @author mohan
 *
 */
@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class, PDFActionTest.class})
public class MyTestSuite {

}
