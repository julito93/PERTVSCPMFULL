package co.com.icesi.backend;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.icesi.backend.model.Task;
import co.com.icesi.backend.model.Transition;
import co.com.icesi.backend.model.TransitionId;
import co.com.icesi.backend.services.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests
{

	@Autowired
	TaskService service;

	@Test
	public void contextLoads()
	{

		Task start = new Task(1, "START", 0.0);
		Task taskA = new Task(3, "A", 2.0);
		Task taskB = new Task(3, "B", 6.0);
		Task taskC = new Task(4, "C", 4.0);
		Task taskD = new Task(5, "D", 3.0);
		Task taskE = new Task(6, "E", 5.0);
		Task taskF = new Task(7, "F", 4.0);
		Task taskG = new Task(8, "G", 2.0);
		Task taskFinish = new Task(9, "FIN", 0.0);

		TransitionId id = new TransitionId(start, taskA);
		Transition edge = new Transition(id, "FS");
		start.getSuccessors().add(edge);
		taskA.getPredecessors().add(edge);

		id = new TransitionId(start, taskB);
		edge = new Transition(id, "FS");
		start.getSuccessors().add(edge);
		taskB.getPredecessors().add(edge);

		id = new TransitionId(start, taskC);
		edge = new Transition(id, "FS");
		start.getSuccessors().add(edge);
		taskC.getPredecessors().add(edge);

		id = new TransitionId(taskA, taskD);
		edge = new Transition(id, "FS");
		taskA.getSuccessors().add(edge);
		taskD.getPredecessors().add(edge);

		id = new TransitionId(taskA, taskF);
		edge = new Transition(id, "FS");
		taskA.getSuccessors().add(edge);
		taskF.getPredecessors().add(edge);

		id = new TransitionId(taskB, taskG);
		edge = new Transition(id, "FS");
		taskB.getSuccessors().add(edge);
		taskG.getPredecessors().add(edge);

		id = new TransitionId(taskC, taskE);
		edge = new Transition(id, "FS");
		taskC.getSuccessors().add(edge);
		taskE.getPredecessors().add(edge);

		id = new TransitionId(taskD, taskG);
		edge = new Transition(id, "FS");
		taskD.getSuccessors().add(edge);
		taskG.getPredecessors().add(edge);

		id = new TransitionId(taskE, taskG);
		edge = new Transition(id, "FS");
		taskE.getSuccessors().add(edge);
		taskG.getPredecessors().add(edge);

		id = new TransitionId(taskG, taskFinish);
		edge = new Transition(id, "FS");
		taskG.getSuccessors().add(edge);
		taskFinish.getPredecessors().add(edge);

		id = new TransitionId(taskF, taskFinish);
		edge = new Transition(id, "FS");
		taskF.getSuccessors().add(edge);
		taskFinish.getPredecessors().add(edge);

		List<Task> tasks = Arrays.asList(start, taskA, taskB, taskC, taskD, taskE, taskF, taskG, taskFinish);

		service.computeEarliestTimes(tasks, start);

		assertThat(start.getEarliestStart()).isEqualTo(0);
		assertThat(taskA.getEarliestStart()).isEqualTo(0);
		assertThat(taskB.getEarliestStart()).isEqualTo(0);
		assertThat(taskC.getEarliestStart()).isEqualTo(0);
		assertThat(taskD.getEarliestStart()).isEqualTo(2);
		assertThat(taskE.getEarliestStart()).isEqualTo(4);
		assertThat(taskF.getEarliestStart()).isEqualTo(2);
		assertThat(taskG.getEarliestStart()).isEqualTo(9);
		assertThat(taskFinish.getEarliestStart()).isEqualTo(11);

	    service.computeLatestTimesAndSlack(tasks, taskFinish);
		
		assertThat(taskFinish.getLatestStart()).isEqualTo(11);
		assertThat(taskG.getLatestStart()).isEqualTo(9);
		assertThat(taskF.getLatestStart()).isEqualTo(7);
		assertThat(taskE.getLatestStart()).isEqualTo(4);
		assertThat(taskD.getLatestStart()).isEqualTo(6);
		assertThat(taskC.getLatestStart()).isEqualTo(0);
		assertThat(taskB.getLatestStart()).isEqualTo(3);
		assertThat(taskA.getLatestStart()).isEqualTo(4);
		assertThat(start.getLatestStart()).isEqualTo(0);

	}

}
