import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { ServiceService} from '../../Service/service.service';
import { Task } from '../../model/Task';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

    tasks:Task[];
    
  constructor(private service:ServiceService, private router:Router ) { }

  ngOnInit() {
      this.service.getTasks()
      .subscribe(data=>{
          this.tasks=data
          });
  }

  update(task:Task)
  {
    localStorage.setItem("id",task.id.toString());
    this.router.navigate(["edit"]);
  }

}
