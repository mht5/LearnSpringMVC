package chapter13.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import chapter02.action.PDFActionTest;

/**
 * Ê¹ÓÃ²âÊÔÌ×¼ş
 * @author mohan
 *
 */
@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class, PDFActionTest.class})
public class MyTestSuite {

}
