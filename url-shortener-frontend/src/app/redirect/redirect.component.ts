import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-redirect',
  template: '<p>Redirecting...</p>', // This is just a placeholder. You might not even need any template.
})
export class RedirectComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    // Get the 'id' from the route
    const id = this.activatedRoute.snapshot.paramMap.get('id');

    if (id) {
      // Redirect to the backend URL
      window.location.href = `https://url.alexbackfish.com:8443/url/${id}`;
    }
  }
}
