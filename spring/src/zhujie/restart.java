package zhujie;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository("RE")
public class restart {
	@Resource
	 private museum mu;
	 public void doIt() {
		 mu.KO();
	 }
}
