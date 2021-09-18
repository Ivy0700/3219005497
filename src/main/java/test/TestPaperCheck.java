package test;

import org.junit.Assert;
import org.junit.Test;
import utils.ProcessUtils;


/**
 *
 * @author zbr
 */
public class TestPaperCheck {

    /**
     * 1.测试不存在的文件testFile/test.txt
     */
    @Test
    public void testNotExistPath(){
        try {
            ProcessUtils.applicationProcess("testfile/test.txt",
                    "testfile/orig.txt", "testfile/result.txt");
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    /**
     * 2.测试空文件testFile/1.txt
     */
    @Test
    public void testEmptyFile() {
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt", "testfile/1.txt","testFile/result.txt" );
        } catch (Exception e) {
            Assert.fail(e.getMessage());
//            System.out.println(e.getMessage());
        }
    }

    /**
     * 3.测试orig.txt和orig_0.8_add.txt
     */
    @Test
    public void testAddFile(){
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt",
                    "testfile/orig_0.8_add.txt", "testfile/result.txt");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }


    }


    /**
     * 4.测试orig.txt和orig_0.8_del.txt
     */
    @Test
    public void testDelFile(){
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt",
                    "testfile/orig_0.8_del.txt", "testfile/result.txt");
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    /**
     * 5.测试orig.txt和orig_0.8_dis_1.txt
     */
    @Test
    public void testDis1File(){
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt",
                    "testfile/orig_0.8_dis_1.txt", "testfile/result.txt");
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    /**
     * 6.测试orig.txt和orig_0.8_dis_10.txt
     */
    @Test
    public void testDis10File(){
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt",
                    "testfile/orig_0.8_dis_10.txt", "testfile/result.txt");
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    /**
     * 7.测试orig.txt和orig_0.8_dis_15.txt
     */
    @Test
    public void testDis15File(){
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt",
                    "testfile/orig_0.8_dis_15.txt", "testFile/result.txt");
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }


    /**
     * 8.测试orig.txt和orig.txt相同的文件
     */
    @Test
    public void testSameFile(){
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt",
                    "testfile/orig.txt", "testfile/result.txt");
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }


    /**
     * 9.传入的文件格式不是txt
     */
    @Test
    public void testWrongFormatFile() {
        try {
            ProcessUtils.applicationProcess("testFile/orig.txt",
                    "testfile/testWordfile.doc", "testFile/result.txt");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
//            System.out.println(e.getMessage());
        }
    }


    /**
     * 10. 测试orig.txt和orig_0.8_dis_20.txt
     */
    @Test
    public void testDis20File() {
        try {
            ProcessUtils.applicationProcess("testfile/orig.txt",
                    "testfile/orig_0.8_dis_20.txt", "testfile/result.txt");
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }
}
