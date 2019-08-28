import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Task } from 'src/app/model/Task';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  task:Task = new Task();

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.edit(); 
  }

  edit()
  {
    let id=localStorage.getItem("id");
    this.service.getTaskById(+id)
    .subscribe(data=>{
      this.task=data;
    })
  }

  update(task:Task)
  {
    this.service.update(task)
    .subscribe(data=>{
      this.task=data;
      alert("Task Updated Successfully");
      this.router.navigate(["list"]);
    })

  }

}
