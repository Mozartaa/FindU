import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class Test1 {

    private static final String URL_Path = "http://39.107.126.145/";

    @Test
    public void test() throws Exception{
        //1. 加载配置文件
        ClientGlobal.init("G:\\javaProject\\FindU\\src\\main\\resources\\fdfs_client.conf");
        //2. 创建管理端对象
        TrackerClient trackerClient = new TrackerClient();
        //3. 通过管理端对象获取连接
        TrackerServer connection = trackerClient.getConnection();
        //4. 创建存储端对象
        StorageClient1 storageClient = new StorageClient1(connection, null);

        //创建文件属性信息对象数组
        NameValuePair[] meta_list = new NameValuePair[3];
        meta_list[0] = new NameValuePair("fileName","idea");
        meta_list[1] = new NameValuePair("ExtName","jpg");
        meta_list[2] = new NameValuePair("zuozhe","gaowei");

        //5. 上传文件
        String path = storageClient.upload_file1("G:\\abc.jpg", "jpg", meta_list);
        System.out.println(URL_Path + path);
    }

}
