import { Component, OnInit } from '@angular/core';
import { ResponseService } from '../response.service';
import { ResponseModule } from '../models/response/response.module';
import { HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  error!:boolean;
  load!:boolean;
  response!: ResponseModule;
  value!: string;
  constructor(private responseService: ResponseService

    ) { }

  ngOnInit(): void {
  }



  onSubmit() {
    this.load=true;
    this.responseService.getWeather (this.value).subscribe(resposta => {
      console.log("passou")
      this.error= false;

    this.response= resposta;
    this.load=false;

    },
    (error) => {
      this.error= true;
      this.load=false;

      console.log("errou")
      console.log(this.error)

    })

  }
}
