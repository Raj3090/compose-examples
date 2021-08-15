package com.example.composelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelist.ui.theme.ComposelistTheme
import com.skydoves.landscapist.coil.CoilImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposelistTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    //pass data from here
   val viewModel = MoviesViewModel()
   val movies=viewModel.movies.observeAsState()

    movies.value?.let {
        MovieList(it)
    }

}


@Composable
fun MovieList(messages: List<Movie>) {
    LazyColumn(  verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(messages) { movie ->
            MovieRow(movie)
        }
    }
}

@Composable
fun MovieRow(movie: Movie) {
    Surface(color = Color.LightGray) {
        Row (verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier.fillMaxSize()
        ){
            CoilImage(
                imageModel = movie.posterUrl,
                contentDescription = "movie poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .clip(CircleShape)
            )
            Text(text = movie.name,color = Color.White,textAlign = TextAlign.Center)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposelistTheme {
        MainContent()
    }
}


class MyLinkedList {

    Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        index=index-1;

        if(index<0 && index>size())return -1;

        int currIndex=0;

        Node curr=head;

        while(curr!=null&&index!=currIndex){
            currIndex++;
        }

        return curr.val;

    }

    /** Get the Node of the index-th node in the linked list. If the index is invalid, return -1. */
    public Node getNodeAt(int index) {
        index=index-1;

        if(index<0 && index>size())return -1;

        int currIndex=0;

        Node curr=head;

        while(curr!=null&&index!=currIndex){
            currIndex++;
        }

        return curr;

    }

    public int size(){
        int size=0;
        Node curr=head;

        while(curr!=null){
            size++;
        }

        return size;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node=new Node(val);

        if(head==null){
            head=node;
        }else{
            node.next=head;
            head=node;
        }

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void deleteHead() {
        if(head==null){
            return;
        }

        head=head.next;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        if(head==null){
            head=new Node(val);
        }else{
            Node curr=head;

            while(curr.next!=null){
                curr=curr.next;
            }

            curr.next=new Node(val);

        }

    }

    /** Append a node of value val to the last element of the linked list. */
    public void deleteTail() {

        if(head==null){
            return;
        }else{
            Node curr=head;

            while(curr.next!=null&&curr.next.next!=null){
                curr=curr.next;
            }

            curr.next=null;

        }

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index<0 && index>size()+1)return;

        if(index==1){
            addAtHead(val);
        }

        if(index==size()+1){
            addAtTail(val);
        }



        Node curr=new Node(val);

        Node next=getNodeAt(index);
        Node prev=getNodeAt(index-1);

        prev.next=curr;
        curr.next=next;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(index<0 && index>size())return;

        if(index==1){
            deleteHead();
        }

        if(index==size()+1){
            deleteTail();
        }


        if(head==null){
            return;
        }else{

            Node next=getNodeAt(index);

            Node prev=getNodeAt(index-1);

            prev.next=next.next;

        }
    }

}

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */