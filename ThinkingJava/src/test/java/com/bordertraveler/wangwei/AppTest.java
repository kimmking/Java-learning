package com.bordertraveler.wangwei;

import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Random rand = new Random(90);
    	
    	for(int i =0 ;i < 20 ; i++){
    		
    	 	int e = rand.nextInt();
        	
        	System.out.println(e);
    		
    	}
   
        assertTrue( true );
    }
}
