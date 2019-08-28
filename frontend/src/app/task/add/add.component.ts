import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { ServiceService} from '../../Service/service.service';
import { Task } from '../../model/Task';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  task:Task =
  {
    id:0,
    name:"",
    duration:0
  };
 
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  add()
  {
    this.service.createTask(this.task)
    .subscribe(data => {
      alert("Task Added Successfully");
      this.router.navigate(["list"]);
      });
  }

}
