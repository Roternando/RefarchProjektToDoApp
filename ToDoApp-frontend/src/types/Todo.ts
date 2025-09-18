import type {SubTodo} from "@/types/SubTodo.ts";

export interface Todo {
    id: string;
    name: string;
    subTodos?: SubTodo;
}