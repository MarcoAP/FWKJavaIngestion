package com.everis.fwkcore.interfaces;

import com.everis.fwkcore.models.HdfsModel;

public interface IHdfs {

	public boolean removeFile(HdfsModel hdfs);

	public boolean insertFile(HdfsModel hdfs);

	public boolean removeDir(HdfsModel hdfs);

	public boolean createDir(HdfsModel hdfs);

}
