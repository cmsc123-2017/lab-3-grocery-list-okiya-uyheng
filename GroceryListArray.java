class GroceryListArray implements IGroceryList {
  
  int max = 10;
  GroceryItem items[] = new GroceryItem[max];
  int size = 0;
  
  GroceryListArray() {}
    
  
  public boolean add(GroceryItem item) {
    
    int i = indexOf(item);
    if (i > -1) {
      items[i].addQuantity(item.quantity);
      return true;
    } else if (size == max) {
      // create new array with bigger length
      // int max = max + 10;
      // GroceryItems bigger[] = new GroceryItem[max]
      // copy items to new array
      // assign new array to items
      
      
      /* Fields:
       * max -- int
       * items[] -- GroceryItem
       * size -- int
       * 
       * Methods:
       * indexOf(GroceryItem)
       * remove(String)
       * markAsBought(String)
       * 
       * Fields of GroceryItem:
       * name -- String
       * quantity -- int
       * isBought -- boolean
       * 
       * Methods of GroceryItem:
       * addQuantity(int)
       * buy()
       * toString()
       * equals(Object)
       * 
       */
      //items = createNewArrayList();
      int newMax = max + 10;
      GroceryItem[] bigger = new GroceryItem[newMax];
      for(int a = 0; a < this.size; a++){
        bigger[a] = items[a];
      }
      items = bigger;
      
    }  
    items[this.size] = item;
    this.size++;
    
    return true;
  }
  
  int indexOf(GroceryItem item) {
    for (int i = 0; i < this.size; i++) {
      if (item.equals(items[i])) {
        return i;
      }
    }
    
    return -1;
  }
  
  public boolean remove(String name) {
    if (size == 0) {
      return false; 
    }
    
    GroceryItem item = new GroceryItem(name, 0);
    for (int i = 0; i < this.size; i++) {
      if (item.equals(items[i])) {
        if(i == this.size - 1){
          this.size--;
        return true;
        }else{// if(i == 0){
          //GroceryItem temp = new GroceryItem(name, 0);
          for(int j = indexOf(item); j < this.size - 1; j++){
            items[j] = items[j + 1];
          }
          this.size--;
        return true;
        }
          
      }
    
    
    }
    return false;
  }
  
  public boolean markAsBought(String name) {
    GroceryItem item = new GroceryItem(name, 0);
    for (int i = 0; i < this.size; i++) {
      if (item.equals(items[i])) {
        items[i].buy();
        return true;
      }
    }
    
    return false;
  }
  

  public void display() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(items[i]);
    }
  }
  
  // -> int
  //Returns the number of individiual items in this GroceryList
  /* Fields:
       * max -- int
       * items[] -- GroceryItem
       * size -- int
       * 
       * Methods:
       * indexOf(GroceryItem)
       * remove(String)
       * markAsBought(String)
       * 
       * Methods of GroceryItem:
       * addQuantity(int)
       * buy()
       * toString()
       * equals(Object)
       * 
       * -> int
       * //returns the quantity of this GroceryItem
       * for(int i = 0; i < this.size; i++){
       * 
       * }
       * 
       *int getQuantity() {
       *   return 0;
       * }
       * 
       */
  public int totalQuantity() {
    int sum = 0;
    for(int i = 0; i < this.size; i++){
      sum = sum + items[i].getQuantity();
    }
    return sum;
  }
  
  //String, int -> boolean
  //Returns true if the quantity of a given item has been reduced.
  //The item is removed if it's quantity is zero or less

  /* Fields:
       * max -- int
       * items[] -- GroceryItem
       * size -- int
       * 
       * Methods:
       * indexOf(GroceryItem)
       * remove(String)
       * markAsBought(String)
       * 
       * 
       * Methods of GroceryItem:
       * addQuantity(int)
       * buy()
       * toString()
       * equals(Object)
       * getQuantity()
       * 
       * for(int i = 0; i < this.size; i++){
       * 
       * }
       * 
       * int -> void
       * reduces the quantity of this GroceryItem
       * void reduce(int) {
       * }
       */
  public boolean reduceQuantity(String itemName, int quantity){
    GroceryItem item = new GroceryItem(itemName, 0);
    for (int i = 0; i < this.size; i++) {
      if (item.equals(items[i])) {
        items[i].reduce(quantity);
        if(items[i].getQuantity() < 1){
          remove(itemName);
        }
        return true;
      }
    }
    return false;
  }
}