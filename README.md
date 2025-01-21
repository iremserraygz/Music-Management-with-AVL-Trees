# Binary Search Tree Map-Based Music Record System

This project involves creating a record system using AVL trees to manage musical records. The system supports insertion, search, and deletion operations, with data initially loaded from a text file.



### Key Features

1. **Data Loading**:
   - Musical records are read from a text file located at `D:\songs.txt`.
   - Each record in the file is formatted as:
     ```
     Song Name;Artist;ID;Genre;Year
     ```
     Example:
     ```
     İki Keklik;Erkan Oğur;1003;Türk Halk;1996
     ```
   - Records are stored in an array for quick access.

2. **AVL Trees**:
   - Three separate AVL trees are created based on:
     - **ID** field: `(index, ID)` pairs.
     - **Song Name** field: `(index, song name)` pairs.
     - **Artist** field: `(index, artist)` pairs.
   - The `index` refers to the position of the record in the array.

3. **Search Operations**:
   - **Single Field Search**: Find songs based on ID, song name, or artist.
   - **Genre Search**: Display all songs belonging to a specific genre.
   - **Range Search**: List all songs with IDs within a given range.

4. **Deletion**:
   - Records can be deleted from all three trees using the ID field.
   - Deletion does not remove the record from the array.

5. **Interactive Menu**:
   - The user can select operations such as insertion, search, and deletion through a menu.

6. **Demonstration**:
   - Students must demonstrate the project on declared dates. One randomly selected group member will answer questions during the demo.

### Implementation Requirements

- **Song Class**:
  A `Song` class is created to represent each record. Each song read from the file is instantiated as a `Song` object.
- **Insertion**:
  Records are inserted into the three AVL trees when the text file is initially read.
- **Search and Delete**:
  - Search operations can be performed based on user input.
  - Deletion is restricted to the ID field.
- **Output**:
  - Search results display all fields of the matching record.
  - If no record is found, an appropriate message is shown.

### Example Menu

```plaintext
1. Search Song by ID, Name, or Artist
2. List Songs by Genre
3. Search Songs by ID Range
4. Delete a Song by ID
5. Exit
```

### File Format
Create a `songs.txt` file in the following format:

```plaintext
Song Name;Artist;ID;Genre;Year
İki Keklik;Erkan Oğur;1003;Türk Halk;1996
Summer Time;Ella Fitzgerald;2001;Jazz;1968
...
```


