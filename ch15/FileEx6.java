package ch15;

import java.io.*;

//디렉토리에서, 해당 키워드 찾기.

public class FileEx6 {
    static int found = 0;
    public static void main(String[] args) {
        File dir = new File("D:\\Github\\JAVA_RUN-1\\ch15");
        String keyword = "exit";

        if(!dir.isDirectory()||!dir.exists())
        {
            System.out.println("file is not founded.");
            System.out.println("file : "+dir.getName());
            System.exit(0);
        }
        
        try{
            findInfiles(dir,keyword);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("총 "+found+"개의 라인에서"+keyword+"을 발견하였습니다.");
    }

    public static void findInfiles(File dir, String keyword) throws IOException
    {
        File[] files = dir.listFiles();
        for(int i=0;i<files.length;i++)
        {
            if(files[i].isDirectory())
            {
                findInfiles(files[i], keyword);
            }
            else{
                String filename = files[i].getName();
                String extension = filename.substring(filename.lastIndexOf(".")+1);
                extension = ","+extension+",";

                if(",java,txt,bak,".indexOf(extension)==-1){continue;}

                filename = dir.getAbsolutePath() + File.separator+filename;

                FileReader fr = new FileReader(files[i]);
                BufferedReader  br = new BufferedReader(fr);

                String data ="";
                int linenum = 0;

                while((data=br.readLine())!=null)
                {
                    linenum++;

                    if(data.indexOf(keyword)!=-1)
                    {
                        found++;
                        System.out.println("["+filename+"("+linenum+")"+"]"+data);
                    }
                }
                br.close();
            }
        }
    }
}

