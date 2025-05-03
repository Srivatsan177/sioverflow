import { Box, FormControl, TextField } from "@mui/material";
import { CKEditor, useCKEditorCloud } from '@ckeditor/ckeditor5-react';

const NewQuestion = () => {

  const cloud = useCKEditorCloud({
    version: "45.0.0",
    premium: false
  });

  if (cloud.status === "error") {
    console.error(cloud.error)
    return <>Error loading ckeditor</>
  }
  if (cloud.status === "loading") {
    return <>Loading editor...</>
  }

  const {
    ClassicEditor,
    Essentials,
    Paragraph,
    Bold,
    Italic
  } = cloud.CKEditor;

  return (
    <form>
      <FormControl sx={{ gap: 3 }} fullWidth>
        <TextField
          label="Title"
          required
        />
        <TextField
          label="Tags"
        />
        <Box
          sx={{
            "& .ck-editor__editable": {
              minHeight: "20vh"
            }
          }}
        >

          <CKEditor
            editor={ClassicEditor}
            data={"<p>Hello from CKEditor 5!</p>"}
            config={{
              licenseKey: import.meta.env.VITE_CKEDITOR_LICENSE_KEY,
              plugins: [Essentials, Paragraph, Bold, Italic],
              toolbar: ['undo', 'redo', '|', 'bold', 'italic'],
            }}
          />
        </Box>
      </FormControl>
    </form>
  );
}

export default NewQuestion;