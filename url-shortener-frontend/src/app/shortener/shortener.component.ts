import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-shortener',
  templateUrl: './shortener.component.html',
  styleUrls: ['./shortener.component.css']
})
export class ShortenerComponent {
  originalUrl: string = '';
  shortenedUrl: string = '';
  errorMsg: string = '';

  constructor(private http: HttpClient) { }

  isValidUrl(url: string): boolean {
    const pattern = new RegExp('^(https?:\\/\\/)?' + // protocol
      '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.)+[a-z]{2,}|' + // domain name
      '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
      '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*' + // port and path
      '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
      '(\\#[-a-z\\d_]*)?$', 'i'); // fragment locator
    return !!pattern.test(url);
  }

  shortenUrl() {
    
    if (this.isValidUrl(this.originalUrl)) {
      this.http.post<{url: string}>('https://url.alexbackfish.com:8443/add/url', this.originalUrl).subscribe(
    response => {
      this.shortenedUrl = 'https://url.alexbackfish.com/' + response.url;
      this.errorMsg = '';
    },
    error => {
        this.errorMsg = 'Error shortening URL. Please try again.';
        this.shortenedUrl = '';
    }
);
    } else {
      this.errorMsg = 'Invalid URL. Please enter a valid URL.';
      this.shortenedUrl = '';
    }
  }
}
