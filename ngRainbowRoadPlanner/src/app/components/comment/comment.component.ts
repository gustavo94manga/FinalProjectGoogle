import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { CommentService } from './../../services/comment.service';
import { Component } from '@angular/core';
import { Comment } from 'src/app/models/comment';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent {


  selected: Comment | null = null;
newTrip: Comment = new Comment();



constructor(private commentService: CommentService,
  private auth: AuthService,
  private route: ActivatedRoute,
  private router: Router,){

}


createTrip(comment: Comment){
  this.commentService.create(comment).subscribe({
    next:(madeComment)=>{
      this.selected=madeComment;
      console.log(madeComment)
    }

  })
}

updateTrip(comment: Comment){
  this.commentService.update(comment).subscribe({
    next:(updatedComment)=>{
    this.selected=updatedComment;
    }
  })
}

}
