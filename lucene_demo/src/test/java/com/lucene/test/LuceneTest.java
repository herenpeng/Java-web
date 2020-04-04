package com.lucene.test;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author hrp
 * 2020/2/11 14:31
 */
public class LuceneTest {

    @Test
    public void createIndex() throws IOException {
        //1、创建一个Directory对象，指定索引保存位置
        //把索引保存进内存中
        //把索引库保存在磁盘中
        Directory directory = FSDirectory.open(new File("G:\\temp\\index").toPath());
        //2、基于Directory对象创建一个IndexWriter对象
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig());
        //3、读取磁盘中的文件，对应每个文件创建一个文档对象
        File dir = new File("G:\\temp\\doc");
        File[] files = dir.listFiles();
        //4、向文档中对象添加域
        for (File f : files) {
            //取文件名
            String fileName = f.getName();
            //文件的路径
            String filePath = f.getPath();
            //文件的内容
            String fileContent = FileUtils.readFileToString(f, "GBK");
            //文件的大小
            long fileSize = FileUtils.sizeOf(f);
            //创建Field
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
            Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
            Field fieldSize = new TextField("size", fileSize + "", Field.Store.YES);
            //创建文档对象
            Document document = new Document();
            //向文档对象中添加域
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            document.add(fieldSize);
            //5、把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        //6、关闭IndexWriter对象
        indexWriter.close();
    }

    @Test
    public void searchIndex() throws IOException {
        //1、创建一个Directory对象，指定索引保存位置
        Directory directory = FSDirectory.open(new File("G:\\temp\\index").toPath());
        //2、基于Directory对象创建一个IndexReader对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //3、创建一个IndexSearch对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //4、创建一个query对象，TermQuery
        Query query = new TermQuery(new Term("content", "spring"));
        //5、执行查询，得到一个topDocs对象
        //参数一：查询对象 参数二：查询结果返回的最大记录数
        TopDocs topDocs = indexSearcher.search(query, 10);
        //6、取查询结果的总记录数
        System.out.println("查询结果的总记录数为：" + topDocs.totalHits);
        //7、取文档列表
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        //8、打印文档中的内容
        for (ScoreDoc doc : scoreDocs) {
            //取文档Id
            int docId = doc.doc;
            //根据id取文档对象
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
            System.out.println(document.get("content"));
            System.out.println("-------------寂寞的分割线------------");
        }
        //9、关闭IndexWriter对象
        indexReader.close();
    }

    /**
     * 查看分词器的效果
     * @throws Exception
     */
    @Test
    public void testTokenStream() throws Exception{
        Analyzer analyzer = new StandardAnalyzer();
        TokenStream tokenStream = analyzer.tokenStream("","The Spring Framework provides a good framework");
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while(tokenStream.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
        tokenStream.close();
    }

    @Test
    public void testTokenStream2() throws Exception{
        Analyzer analyzer = new IKAnalyzer();
        TokenStream tokenStream = analyzer.tokenStream("","IDEA是一个优秀的Java集成开发环境");
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while(tokenStream.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
        tokenStream.close();
    }


}
