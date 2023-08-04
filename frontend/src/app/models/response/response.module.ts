import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExchangeModule } from '../exchange/exchange.module';
import { CountryData } from '../country-data/country-data.module';
import { Weather } from '../weather-data/weather-data.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ResponseModule {
   'weather': Weather;
 'countryData': CountryData;
 'exchange': ExchangeModule;
 'httpStatus': any;

}
