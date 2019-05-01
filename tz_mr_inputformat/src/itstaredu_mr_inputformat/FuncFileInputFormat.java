package itstaredu_mr_inputformat;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
/**
 * 
 * @ClassName:  FuncFileInputFormat   
 * @Description:  判断是否切分 
 * @author:  lilong
 * @date:   2019年1月13日 下午5:46:42
 */
public class FuncFileInputFormat extends FileInputFormat<NullWritable, BytesWritable> {

	@Override
	protected boolean isSplitable(JobContext context, Path filename) {

		// 不切原来的文件
		return false;
	}
	
	@Override
	public RecordReader<NullWritable, BytesWritable> createRecordReader(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		
		FuncRecordReader RecordReader = new FuncRecordReader();
		
		return RecordReader;
	}

}
