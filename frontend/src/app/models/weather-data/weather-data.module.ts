import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class Weather {
  'id': number;
  'city': string;
  'main': string;
  'description': string;
  'icon': string;
  'temperature': number;
  'humidity': number;
  'country': string;
  'temp_min': any;
  'temp_max': any

}
