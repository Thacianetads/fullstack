import { Component, inject, signal } from '@angular/core';
import { NgClass, NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { TodoService } from './todo.services';

export interface TodoItem {
  id: number;
  name: string;
  description: string;
  completed: boolean;
  priority: number;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, NgFor, NgClass, NgIf],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('frontend');

  private todoService = inject(TodoService);

  todoList: TodoItem[] = [];

  newTask: Partial<TodoItem> = {
    name: '',
    description: '',
    priority: 1,
  };

  priorities: number[] = [1, 2, 3, 4, 5];

  editingTask: TodoItem | null = null;

  constructor() {
    this.loadTasks();
  }

  loadTasks(): void {
    this.todoService.getTasks().subscribe({
      next: (tasks) => (this.todoList = tasks),
      error: (err) => console.error('Erro ao carregar tarefas:', err),
    });
  }

  addTask(): void {
    if (this.newTask.name?.trim()) {
      this.todoService.addTask(this.newTask).subscribe({
        next: (updatedList) => {
          this.todoList = updatedList;
          this.newTask = { name: '', description: '', priority: 1 };
        },
        error: (err) => console.error('Erro ao adicionar tarefa:', err),
      });
    }
  }

  toggleCompleted(index: number, completed: boolean): void {
    const updatedTask = { ...this.todoList[index], completed };
    this.todoService.updateTask(updatedTask).subscribe({
      next: (updatedList) => (this.todoList = updatedList),
      error: (err) => console.error('Erro ao atualizar tarefa:', err),
    });
  }

  deleteTask(id: number): void {
    this.todoService.deleteTask(id).subscribe({
      next: (updatedList) => (this.todoList = updatedList),
      error: (err) => console.error('Erro ao deletar tarefa:', err),
    });
  }

  editTask(task: TodoItem): void {
    this.editingTask = { ...task };
  }

  saveEdit(): void {
    if (this.editingTask) {
      this.todoService.updateTask(this.editingTask).subscribe({
        next: (updatedList) => {
          this.todoList = updatedList;
          this.editingTask = null;
        },
        error: (err) => console.error('Erro ao salvar edição:', err),
      });
    }
  }

  cancelEdit(): void {
    this.editingTask = null;
  }
}
