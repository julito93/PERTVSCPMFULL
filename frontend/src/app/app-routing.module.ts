import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditComponent } from "src/app/task/edit/edit.component";
import { AddComponent } from "src/app/task/add/add.component";
import { ListComponent } from "src/app/task/list/list.component";
import { TransitionComponent} from "src/app/transition/transition.component";


const routes: Routes = [
    { path: 'list', component: ListComponent },
    { path: 'add', component: AddComponent },
    { path: 'edit', component: EditComponent },
    { path: 'transitions', component: TransitionComponent }
];

@NgModule( {
    imports: [RouterModule.forRoot( routes )],
    exports: [RouterModule]
} )
export class AppRoutingModule { }
