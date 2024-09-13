package jpaHibernate05CompositeKey.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "pid")
	private Integer pid;

	@Column(name = "pgmId")
	private Integer pgmId;

	public ProjectInfo() {
	}

	public ProjectInfo(Integer pid, Integer pgmId) {
		this.pid = pid;
		this.pgmId = pgmId;
	}

	@Override
	public String toString() {
		return "ProjectInfo [pid=" + pid + ", pgmId=" + pgmId + "]";
	}

}
