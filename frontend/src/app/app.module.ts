import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from'@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListComponent } from './task/list/list.component';
import { AddComponent } from './task/add/add.component';
import { EditComponent } from './task/edit/edit.component';
import {ServiceService} from '../app/Service/service.service';
import { TransitionComponent } from './transition/transition.component';



@NgModule( {
    declarations: [
        AppComponent,
        ListComponent,
        AddComponent,
        EditComponent,
        TransitionComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
    ],
    providers: [ServiceService],
    bootstrap: [AppComponent]
} )
export class AppModule {}
