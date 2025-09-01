import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TodoItem } from './app';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private apiUrl = 'http://localhost:8080/tasks';

  constructor(private http: HttpClient) {}

  getTasks(): Observable<TodoItem[]> {
    return this.http.get<TodoItem[]>(this.apiUrl);
  }

  getTaskById(id: number): Observable<TodoItem> {
    return this.http.get<TodoItem>(`${this.apiUrl}/${id}`);
  }

  addTask(task: Partial<TodoItem>): Observable<TodoItem[]> {
    return this.http.post<TodoItem[]>(this.apiUrl, task);
  }

  updateTask(task: TodoItem): Observable<TodoItem[]> {
    return this.http.put<TodoItem[]>(this.apiUrl, task);
  }

  deleteTask(id: number): Observable<TodoItem[]> {
    return this.http.delete<TodoItem[]>(`${this.apiUrl}/${id}`);
  }
}
